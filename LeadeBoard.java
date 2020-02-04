package practice.org;

/**
 * 
 * 
 * Alice is playing an arcade game and wants to climb to the top of the leaderboard and wants to track her ranking. The game uses Dense Ranking, so its leaderboard works like this:

The player with the highest score is ranked number  on the leaderboard.
Players who have equal scores receive the same ranking number, and the next player(s) receive the immediately following ranking number.
For example, the four players on the leaderboard have high scores of , , , and . Those players will have ranks , , , and , respectively. If Alice's scores are ,  and , her rankings after each game are ,  and .

Function Description

Complete the climbingLeaderboard function in the editor below. It should return an integer array where each element  represents Alice's rank after the  game.

climbingLeaderboard has the following parameter(s):

scores: an array of integers that represent leaderboard scores
alice: an array of integers that represent Alice's scores
Input Format

The first line contains an integer , the number of players on the leaderboard.
The next line contains  space-separated integers , the leaderboard scores in decreasing order.
The next line contains an integer, , denoting the number games Alice plays.
The last line contains  space-separated integers , the game scores.

Constraints

 for 
 for 
The existing leaderboard, , is in descending order.
Alice's scores, , are in ascending order.
Subtask

For  of the maximum score:

Output Format

Print  integers. The  integer should indicate Alice's rank after playing the  game.
 *
 */
public class LeadeBoard {
	
	public static int[] solution(int[] scores, int[] alice) {
		
		int[] ranks = new int[scores.length];
		int[] res = new int[alice.length];
		
		getRanks(scores, ranks);
		
		for(int i=0; i<alice.length; i++) {
			int score = alice[i];
			if(score >= scores[0]) {
				res[i] = 1;
			}else if(score < scores[scores.length-1] ) {
				res[i] = ranks[scores.length-1]+1;
			}else {
				int index = binarySearch(scores, score);
				res[i] = ranks[index];
			}
			
			System.out.println(res[i]+" ");
		}
		return res;
	}
	
	private static void getRanks(int[] scores, int[] ranks) {
		
		ranks[0] = 1;
		for(int i=1; i<scores.length; i++) {
			if(scores[i] == scores[i-1]) {
				ranks[i] = ranks[i-1];
			}else {
				ranks[i] = ranks[i-1]+1;
			}
		}
		
	}
	
	private static int binarySearch(int[] scores, int score) {
		
		
		return binarySearch(scores, scores.length-1, 0, score);
	}
	
	private static int binarySearch(int[] a, int hi, int lo, int key) {
		
		if(hi < lo) return -1;
		
		int mid = lo + (hi -lo)/2;
		
		if(key == a[mid])
			return mid;
		else if(key > a[mid] && key < a[mid-1] ) {
			return mid;
		}else if(key < a[mid] && key > a[mid+1]) {
			return mid+1;
		}else if(key < a[mid]) {
			return binarySearch(a, hi, mid+1, key);
		}else {
			return binarySearch(a, mid-1, lo, key);
		}
		//return -1;
	}
	
	public static void main(String[] args) {
		
		int[] scores = {100, 100, 50, 40, 40, 20, 10};
		int[] alice = {5, 25, 50, 120};
		
		solution(scores, alice);
	}

}
