package Pratice;
public class Array {
	//��������������
	int a[] = new int[5];
	//���鸳���ֵ
	void initArray() {
		for(int i =0;i < a.length;i++) {
			a[i] = (int)(Math.random()*100);
		}
	}
	// ѡ�������С����
	void selectSort() {
		int tempS;
		for(int x = 0;x < a.length;x++) {
			for(int y = x+1;y < a.length;y++) {
				if(a[x] > a[y]) {
					tempS = a[x];
					a[x] = a[y];
					a[y] = tempS;
				}
			}
		}
	}
	//ð������Ӵ�С
	void bubbleSort() {
		int tempB;
		for(int x = 0;x < a.length;x++) {
			for(int y = 0;y < a.length-x-1;y++) {
				if(a[y] < a[y+1]) {
					tempB = a[y];
					a[y] = a[y+1];
					a[y+1] = tempB;
				}
			
			}
		}
	}
	//�������
	void outPut() {
		System.out.println("\n");
		for(int i =0;i < a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}
	//������

}
