package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

import static org.example.HelperClass.*;

public class FunctionalClass {


	public static HashSet<Integer> createOtherVertexGroup(int[][] mas, HashSet<Integer> endSet){

		HashSet<Integer> hashSet = new HashSet<>();

		for(int i = 0; i < mas.length; i++){
			if(!endSet.contains(i)){
				hashSet.add(i);
			}
		}

		return hashSet;
	}


	public static ArrayList<HashSet<Integer>> countingGroup(ArrayList<HashSet<Integer>> groupList, int[][] mas){

		boolean check = true;
		int it = 0;
		printGroupList(groupList);
		while (check) {

			check = false;

			ArrayList<HashSet<Integer>> newGroupList = new ArrayList<>();

			for (HashSet<Integer> set : groupList) {
				boolean secondCheck = false;
				for (int i : set) {
					for (int j = 0; j < mas[i].length; j++) {

						if (!set.contains(mas[i][j]) && (set.size() != 1)) {
							HashSet<Integer> newGroupSet = new HashSet<>();
							newGroupSet.add(i);
							set.remove(i);

							newGroupList.add(set);
							newGroupList.add(newGroupSet);

							secondCheck = true;
							check = true;
							break;
						}
//					} else {
//						System.out.println("[" + i + ", " + j + "] -> " + mas[i][j]);
//					}
					}
					if(secondCheck){
						break;
					}
				}
				if(!secondCheck){
					newGroupList.add(set);
				}
			}
			groupList = newGroupList;
			printGroupList(groupList);
		}
		return groupList;
	}


	public static void countingNewMas(int[][] mas, int[][] newMas, ArrayList<HashSet<Integer>> groupList){

		for(int i = 0; i < mas.length; i++){
			for(int j = 0; j < mas[i].length; j++) {

				int index = mas[i][j];
				int xIndex = i;

//				System.out.println("{" + xIndex + "; " + j + "} = " + index);

				for (HashSet<Integer> set : groupList) {
					if (set.contains(mas[i][j])) {
						for (int k : set) {
							index = k;
							break;
						}
						if(set.size() > 1 && xIndex > index){
							xIndex = index;
						}
						break;
					}
				}

//				System.out.println("{" + xIndex + "; " + j + "} = " + index);

				newMas[xIndex][j] = index;
				System.out.println();
			}
		}

	}

}
