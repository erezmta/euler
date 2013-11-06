package com.gmail.erezmta.euler;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import com.gmail.erezmta.euler.Q11.Matrix.Coordinate;
import com.gmail.erezmta.euler.Q11.Matrix.CoordinateDeltaOption;
import com.gmail.erezmta.euler.utils.IOUtils;

public class Q11 {
	private Matrix matrix;

	public Q11(String filename) {
		this.matrix = new Matrix(filename);
	}

	public long calcMaxProduct() {
		long max = -1;
		for (int x = 0; x < matrix.getMaxX(); x++) {
			for (int y = 0; y < matrix.getMaxY(); y++) {
				Coordinate c = matrix.new Coordinate(x, y);
				for (CoordinateDeltaOption option : matrix.getOptions()) {

					List<Coordinate> coordinates = option
							.generatedCoordinates(c);
					if (coordinates == null)
						break;

					long product = coordinates.get(0).getVal()
							* coordinates.get(1).getVal()
							* coordinates.get(2).getVal()
							* coordinates.get(3).getVal();
					if (max < product) {
						max = product;
					}
				}
			}
		}

		return max;
	}

	public static class Matrix {
		private List<List<Integer>> matrix;
		private int maxX;
		private int maxY;
		private List<CoordinateDeltaOption> options;

		public Matrix(String filename) {
			new MatrixReader().readMatrixFromFile(filename);
			calculateOptions();
		}

		public List<CoordinateDeltaOption> getOptions() {
			return this.options;
		}

		public int getMaxX() {
			return this.maxX;
		}

		public int getMaxY() {
			return this.maxY;
		}

		private void calculateOptions() {
			options = new ArrayList<>();

			for (Direction direction1 : Direction.values()) {
				CoordinateDeltaOption option = new CoordinateDeltaOption(
						direction1, direction1, direction1);

				if (option.isValid()) {
					options.add(option);
				}

			}
		}

		public static enum Direction {
			DOWN(0, 1), RIGHT(+1, 0), DOWN_RIGHT(+1, +1), DOWN_LEFT(-1, +1), ;

			int xDelta, yDelta;

			private Direction(int xDelta, int yDelta) {
				this.xDelta = xDelta;
				this.yDelta = yDelta;
			}
		}

		public class CoordinateDeltaOption {
			private static final int NUMBER_OF_NUMBERS = 4;
			private final List<Coordinate> coordinatesDelta;

			public CoordinateDeltaOption(Direction... directions) {
				int numberOfDeltas = NUMBER_OF_NUMBERS - 1;
				if (directions.length != numberOfDeltas) {
					throw new RuntimeException(String.format(
							"Expected %d directions, but got: %d",
							numberOfDeltas, directions.length));
				}

				coordinatesDelta = new ArrayList<Coordinate>(numberOfDeltas);
				Coordinate previousCoordinate = new Coordinate(0, 0);
				for (Direction direction : directions) {
					previousCoordinate = new Coordinate(
							previousCoordinate.getX() + direction.xDelta,
							previousCoordinate.getY() + direction.yDelta);
					this.coordinatesDelta.add(previousCoordinate);
				}
			}

			public boolean isValid() {
				return new HashSet<>(coordinatesDelta).size() == coordinatesDelta
						.size();
			}

			public List<Coordinate> generatedCoordinates(Coordinate c) {
				Coordinate c1 = Matrix.this.new Coordinate(c,
						coordinatesDelta.get(0));
				if (c1.isInValid())
					return null;

				Coordinate c2 = Matrix.this.new Coordinate(c,
						coordinatesDelta.get(1));
				if (c2.isInValid())
					return null;

				Coordinate c3 = Matrix.this.new Coordinate(c,
						coordinatesDelta.get(2));
				if (c3.isInValid())
					return null;

				return Arrays.asList(c, c1, c2, c3);
			}
		}

		private class MatrixReader {
			public void readMatrixFromFile(String filename) {
				URL url = this.getClass().getClassLoader()
						.getResource(filename);

				matrix = new ArrayList<List<Integer>>();

				Scanner scanner;
				try {
					File file = new File(url.getFile());
					scanner = new Scanner(file);
				} catch (FileNotFoundException e) {
					throw new RuntimeException("Cannot file the file: "
							+ url.getFile());
				}

				try {
					while (scanner.hasNextLine()) {
						List<Integer> line = new ArrayList<Integer>();
						matrix.add(line);
						Scanner lineS = new Scanner(scanner.nextLine());

						try {
							while (lineS.hasNextInt()) {
								line.add(lineS.nextInt());
							}
						} finally {
							IOUtils.closeSilently(lineS);
						}
					}
				} finally {
					IOUtils.closeSilently(scanner);
				}

				validateMatrix();
			}

			private void validateMatrix() {
				maxX = matrix.get(0).size();
				maxY = matrix.size();

				for (List<Integer> line : matrix) {
					if (line.size() != maxX) {
						throw new RuntimeException(String.format(
								"Error: found line with col# %d", maxY));
						// “Error: found line with col# %d which is different
						// than #cols of the first row: %d”, line.size(),
						// this.maxX);
					}
				}
			}
		}

		public class Coordinate {
			private int x, y;

			public Coordinate(int x, int y) {
				this.x = x;
				this.y = y;
			}

			public Coordinate(Coordinate orig, Coordinate delta) {
				this.x = orig.x + delta.x;
				this.y = orig.y + delta.y;
			}

			public int getX() {
				return x;
			}

			public int getY() {
				return y;
			}

			public boolean isInValid() {
				return !(isInRange(x, maxX) && isInRange(y, maxY));
			}

			private boolean isInRange(int coordinate, int max) {
				return coordinate >= 0 && coordinate < max;
			}

			public int getVal() {
				return matrix.get(x).get(y);
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + x;
				result = prime * result + y;
				return result;
			}

			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Coordinate other = (Coordinate) obj;
				if (x != other.x)
					return false;
				if (y != other.y)
					return false;
				return true;
			}

		}

	}
}
