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

		printFinalMas(mas, groupList);
	}
}