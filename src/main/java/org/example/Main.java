package org.example;

import java.util.ArrayList;
import java.util.HashSet;

import static org.example.FunctionalClass.*;
import static org.example.HelperClass.*;

public class Main {
	public static void main(String[] args) {

		int[][] mas = testCase();

		HashSet<Integer> startVertex = new HashSet();
		startVertex.add(0);
		HashSet<Integer> endVertex = new HashSet<>();
		endVertex.add(4);
		endVertex.add(5);
		printMas(mas, startVertex, endVertex);

		HashSet<Integer> otherVertexSet = createOtherVertexGroup(mas, endVertex);

		ArrayList<HashSet<Integer>> groupList = new ArrayList<>();
		groupList.add(endVertex);
		groupList.add(otherVertexSet);

		groupList = countingGroup(groupList, mas);

		int[][] newMas = new int[groupList.size()][mas[0].length];

		countingNewMas(mas, newMas, groupList);
		printMas(newMas);

	}
}