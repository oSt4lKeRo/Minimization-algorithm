package org.example;

import java.util.ArrayList;
import java.util.HashSet;

import static org.example.FunctionalClass.searchIndex;

public class HelperClass {

	public static int[][] testCase(){

		int[][] mas = new int[6][2];
		mas[0][0] = 1;
		mas[0][1] = 3;
		mas[1][0] = 2;
		mas[1][1] = 4;
		mas[2][0] = 5;
		mas[2][1] = 4;
		mas[3][0] = 2;
		mas[3][1] = 4;
		mas[4][0] = 4;
		mas[4][1] = 5;
		mas[5][0] = 4;
		mas[5][1] = 5;
//		mas[6][0] = 4;
//		mas[6][1] = 1;


		return mas;
	}

	public static void printMas(int[][] mas){
		int ind = 0;
		for(int[] i : mas){
			for(int j : i){
//				if(ind != 3) {
					System.out.print(j + " ");
//				}
			}
//			if(ind != 3)
			System.out.println();
			ind++;
		}
	}

	public static void printMas(int[][] mas, HashSet<Integer> startVertex, HashSet<Integer> endVertex){
		System.out.println();
		for(int[] i : mas){
			for(int j : i){
				System.out.print(j + " ");
			}
			System.out.println();
		}
		System.out.print("Начальные точки: ");
		for(int i : startVertex){
			System.out.print(i + " ");
		}
		System.out.print("\nКонечные точки: ");
		for(int i : endVertex){
			System.out.print(i + " ");
		}
		System.out.println('\n');
	}


	public static void printGroupList(ArrayList<HashSet<Integer>> groupList){
		for(HashSet<Integer> i : groupList){
			System.out.print(i + ", ");
		}
		System.out.println();
	}

	public static void printFinalMas(int[][] mas, ArrayList<HashSet<Integer>> groupList){
		ArrayList<Integer> blockList = new ArrayList<>();
		for(int i = 0; i < mas.length; i++){
			int indexFrom = searchIndex(groupList, i);
			if(!blockList.contains(indexFrom)) {
				blockList.add(indexFrom);
				System.out.print(indexFrom + " |\t");
				for (int j = 0; j < mas[i].length; j++) {

					int indexTo = searchIndex(groupList, mas[i][j]);
					System.out.print(indexTo + "\t");

				}
				System.out.println();
			}
		}
	}
}
