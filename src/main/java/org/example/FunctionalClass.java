package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

import static org.example.HelperClass.*;

public class FunctionalClass {

	static class Helper2{
		int masIndex;
		int index;

		Helper2(int masIndex, int index){
			this.masIndex = masIndex;
			this.index = index;
		}
	}

	static class Helper{
		int indexFrom;
		int indexTo;
		int indexTo2;
		int indexNewSet;
//		int alfTrans;
		int elem;

//		Helper(int indexFrom, int indexTo, int indexNewSet, int alfTrans){
//			this.indexFrom = indexFrom;
//			this.indexTo = indexTo;
//			this.indexNewSet = indexNewSet;
//			this.alfTrans = alfTrans;
//		}

		Helper(int indexFrom, int indexTo, int indexTo2, int elem){
			this.indexFrom = indexFrom;
			this.indexTo = indexTo;
//			this.alfTrans = alfTrans;
			this.elem = elem;
		}

	}

	public static HashSet<Integer> createOtherVertexGroup(int[][] mas, HashSet<Integer> endSet){

		HashSet<Integer> hashSet = new HashSet<>();

		for(int i = 0; i < mas.length; i++){
			if(!endSet.contains(i)){
				hashSet.add(i);
			}
		}

		return hashSet;
	}

	public static int findIndexSet(ArrayList<HashSet<Integer>> groupList, int elem){
		int index = 0;
		for(HashSet<Integer> set : groupList){
			if(set.contains(elem)){
				return index;
			}
			index++;
		}
		return 5;
	}

//	public static int findHelperIndex(ArrayList<Helper> helperList, int indexFrom, int indexTo, int alfTrans){
//		int index = 0;
//		for(Helper i : helperList){
//			if((i.indexFrom == indexFrom) && (i.indexTo == indexTo) && (i.alfTrans == alfTrans)){
//				return index;
//			}
//			index++;
//		}
//		return helperList.size();
//	}

//	public static int findHelperIndex(ArrayList<Helper> helperList, int indexTo, int alfTrans, ArrayList<Integer> blockList){
//		int index = 0;
//		for(Helper i : helperList){
//			if((i.indexTo == indexTo) && (i.alfTrans == alfTrans) && (!blockList.contains(i.elem))){
//				return index;
//			}
//			index++;
//		}
//		return helperList.size();
//	}

//	public static ArrayList<Integer> findHelperFriend(ArrayList<Helper> helperList, int indexTo, int alfTrans, ArrayList<Integer> blockList){
//
//		ArrayList<Integer> mas = new ArrayList<>();
//		for(Helper i : helperList){
//			if((i.indexTo == indexTo) && (i.alfTrans == alfTrans) && (!blockList.contains(i.elem))){
//				mas.add(i.elem);
//			}
//		}
//		return mas;
//	}



	public static ArrayList<HashSet<Integer>> countingGroup(ArrayList<HashSet<Integer>> groupList, int[][] mas) {

		printGroupList(groupList);

		boolean check = false;

		while (!check) {

			check = true;

			ArrayList<HashSet<Integer>> newGroupList = new ArrayList<>();
			ArrayList<Integer> blockList = new ArrayList<>();
			int setIndex = 0;

			for (HashSet<Integer> set : groupList) {
				boolean check2 = true;
				for (int i : set) {
					for (int j = 0; j < mas[i].length; j++) {

						if (!blockList.contains(i)) {
							if (!set.contains(mas[i][j])){
								int indexTo1 = findIndexSet(groupList, mas[i][0]);
								int indexTo2 = findIndexSet(groupList, mas[i][1]);

								Helper helper = new Helper(setIndex, indexTo1, indexTo2, i);
								HashSet<Integer> newSet = new HashSet<>();
								newSet.add(i);
								blockList.add(i);


								for(int k : set){
									if(!blockList.contains(k)){
										indexTo1 = findIndexSet(groupList, mas[k][0]);
										indexTo2 = findIndexSet(groupList, mas[k][1]);
										if(indexTo1 == helper.indexTo && indexTo2 == helper.indexTo2){
											newSet.add(k);
											blockList.add(k);
										}
									}
								}
								check = false;
								newGroupList.add(newSet);
							}
						}


					}
				}
				HashSet<Integer> newSet = new HashSet<>();
				for(int i : set){
					if(!blockList.contains(i)){
						newSet.add(i);
					}
				}
				if(newSet.size() > 0){
					newGroupList.add(newSet);
				}
				setIndex++;
			}
			for(HashSet<Integer> set : newGroupList){
				System.out.print(set + "\t");
			}
			System.out.println();

			if(groupList.equals(newGroupList)) {
				break;
			} else {
				groupList = newGroupList;
			}
		}
		System.out.println();
		return groupList;
	}


	public static void countingNewMas(int[][] mas, int[][] newMas, ArrayList<HashSet<Integer>> groupList) {

		int indexSet = 0;
		for(HashSet<Integer> set : groupList){
			for(int i : set){

				for(int j = 0; j < mas[i].length; j++){

					
				}
			break;
			}
			System.out.println();
			indexSet++;
		}

	}

	public static int searchHelper2(Helper2[] helper2s, int indexElem){
		for(Helper2 i : helper2s){
			if(i.index == indexElem){
				return i.masIndex;
			}
		}
		return 0;
	}

	public static int searchIndex(ArrayList<HashSet<Integer>> groupList, int elem){

		int index = groupList.size();
		for(HashSet<Integer> set : groupList){
			int firstElem = 0;
			for(int i : set){
				firstElem = i;
				break;
			}
			for(int i : set){
				if(i == elem){
					index = firstElem;
					break;
				}
			}
		}
		return index;
	}




}
