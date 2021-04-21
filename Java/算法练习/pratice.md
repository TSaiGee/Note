---
typora-root-url: images
typora-copy-images-to: images
---

# 算法练习 

##入门算法练习

###黄金分割点

寻找两个数的商离黄金分割点0.618最近,要求两数不能同时为偶数,两数取值范围为[1-20]

```java
public class goldenSplit {
	public static void main(String[] args) {
		float quotient = 0;		//定义两个书的商
		float diff = 0;			//定义商与0.618的差值	
		float diff_aim = 20;	//用于保存上一个较小的差值
		int aimx = 0;			//目的数x
		int aimy = 0;			//目的数y
		for(int x = 1;x < 20;x++) {
			for(int y = 1;y < 20;y++) {
				if ((x%2!=0) | (y%2)!=0) {
					quotient = (float)x / y;
					diff = (float) (quotient - 0.618);
					if(diff > 0) {
						diff = diff;
					}
					else {
						diff = -diff;
					}
					if(diff < diff_aim) {
						diff_aim = diff;
						aimx = x;
						aimy = y;
						continue;
					}
					else
						continue;
				}

			}
		}
		System.out.println(aimx);
		System.out.println(aimy);
		System.out.println((float)aimx / aimy);
	}
}
```
###求水仙花数

(水仙花数为三位数,如153=1^3+5^3+3^3,则153是水仙花数)

```Java
public class numOfDaffodils {
	public static void main (String[] args) {
		for(int i = 100;i < 1000;i++) {
			int aim_bit = (int) Math.pow((i % 10), 3);
			int aim_ten = (int) Math.pow((i / 10 % 10), 3);
			int aim_Hundred = (int) Math.pow((i / 100), 3);
			int aim = aim_bit + aim_ten + aim_Hundred;
			if(aim == i) {
				System.out.println(i);
				continue;
			}
			else {
				continue;
			}
		}
	}
}

```
### 一道小学算术题

> ![1608437756037](/1608437756037.png) 
>
> ```Java
> public class Math {
> 	public static void main (String[] args) {
> 		for(int a = 0; a < 9;a++) {
> 			for(int b = 0; b < 9;b++) {
> 				for(int c = 0; c < 15;c++) {
> 					for(int d = 0; d < 15;d++) {
> 						if(a+b == 8) {
> 							if(a+c == 14) {
> 								if(b+d == 10) {
> 									if(c-d == 6) {
> 										System.out.println(a+"\n"+b+"\n"+c+"\n"+d);
> 									}
> 								}
> 							}
> 						}
> 					}
> 				}
> 			}
> 		}
> 	}
> }
> 
> ```

###选择排序

  ```java
  public class selectSort{
      public static void main(String[] args){
          int temp;
          int [] a = new int[5];
          //给数据赋随机数值
          for(int i = 0;i < a.length;i++){
              a[i] = (int) = (int)(java.lang.Math.random()*100);
          }
          //查看数组
          for(int i = 0;i < a.length;i++){
              System.out.println(a[i]);
          }
          //选择排序
          for(int i = 0;i < a.length;i++){
              for(int j = i+1;j < a.length;j++){
                  if(a[i] > a[j]){
                      temp = a[i];
                      a[i] = a[j];
                      a[j] = temp;
                  }
              }
          }
          
          for(int i = 0;i < a.length;i++){
              System.out.println(a[i]);
          }
          
      }
  }
  ```

###冒泡排序

  ```java
  public class bubbleSort{
      public static void main(String[] args){
          int temp;
          int [] a = new int[5];
          //给数据赋随机数值
          for(int i = 0;i < a.length;i++){
              a[i] = (int) = (int)(java.lang.Math.random()*100);
          }
          //查看数组
          for(int i = 0;i < a.length;i++){
              System.out.println(a[i]);
          }
          //冒泡排序
          for(int i = 0;i < a.length;i++){
              for(int j = 0;j < a.length-1-i;j++){
                  if(a[j] > a[j+1]){
                      temp = a[j];
                      a[j] = a[j+1];
                      a[j+1] = temp;
                  }
              }
          }
          
          for(int i = 0;i < a.length;i++){
              System.out.println(a[i]);
          }
          
      }
  }
  ```

###数组逆序

  ```java
  
  ```