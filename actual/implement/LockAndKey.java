package implement;

public class LockAndKey {
	public static void main(String[] args) {
		System.out.println(new Solution().solution(new int[][] { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } },
				new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } }));
	}
}

//25, 29, 31 tc가 안돌아갔었음: M!=N일 경우 고려해야하는데, lockLen을 실수로 key.length로 구현했었음!
class Solution {
	int keyLen;
	int lockLen;
	int[][] padding;

	public boolean solution(int[][] key, int[][] lock) {
		keyLen = key.length; 	//M
		lockLen = lock.length; 	//N
		padding = makePadding(lock);

		// rotate 수 (4번 turn)
		for (int t = 0; t < 4; t++) {
			// i, j : key가 움직이는 거리 (M+N-1) 
			for (int i = 0; i < keyLen + lockLen - 1; i++) {
				for (int j = 0; j < keyLen + lockLen - 1; j++) {
					// 패딩 초기화 
					padding = makePadding(lock);
					
					// x, y: key의 크기
					for (int x = 0; x < keyLen; x++) {
						for (int y = 0; y < keyLen; y++) {
							padding[i + x][j + y] += key[x][y];
						}
					}
					
					if (isOpen(padding))
						return true;
				}
			}
			key = rotate90(key);
		}

		return false;
	}

	private boolean isOpen(int[][] padding) {
		for (int i = 0; i < lockLen; i++) {
			for (int j = 0; j < lockLen; j++) {
				if (padding[i + keyLen - 1][j + keyLen - 1] != 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	private int[][] makePadding(int[][] lock) {
		int paddingLen = (keyLen - 1) * 2 + lockLen;
		int[][] lockAndKey = new int[paddingLen][paddingLen];

		for (int i = 0; i < lockLen; i++) {
			for (int j = 0; j < lockLen; j++) {
				lockAndKey[i + keyLen - 1][j + keyLen - 1] = lock[i][j];
			}
		}
		return lockAndKey;
	}

	private int[][] rotate90(int[][] key) {
		int ret[][] = new int[key.length][key.length];
		for (int i = 0; i < key.length; i++) {
			for (int j = 0; j < key.length; j++) {
				ret[j][key.length - i - 1] = key[i][j];
			}
		}
		return ret;
	}
}