package sparseArray;

public class SparseArray {

    /**
     * 将一个默认值为0第原始数组转换为稀疏数组，再将稀疏数组转换为原始数组
     * 其中：array[][]为原始数组，sparseArray[][]为转换后的稀疏数组，arrayParse[][]为将稀疏数组还原为原始数组的解析数组
     * @param args
     */
    public static void main(String[] args) {

        /**
         * 创建原始数组
         */
        //创建原始数组
        int[][] array = new int[11][10];
        array[0][0] = 1;
        array[2][3] = 1;
        array[4][5] = 2;


        //打印原始数组
        System.out.println("原始数组为：");
        for (int i = 0; i < array.length;i++){
            for (int j = 0;j < array[i].length;j++){
                System.out.print(array[i][j] + "  ");
            }
            System.out.println();
        }

        System.out.println("*****************");

        /**
         * 将原始数组转换为稀疏数组
         */

        //判断原始数组中非0总个数
        int sum = 0;
        for (int i = 0; i < array.length;i++){
            for (int j = 0;j < array[i].length;j++){
                if (array[i][j] != 0){
                    sum++;
                }
            }
        }
        System.out.println("sum :" + sum);

        //创建稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        //将原始数组的大小值，传入稀疏数组
        sparseArray[0][0] = array.length;       //定义行数
        sparseArray[0][1] = array[0].length;    //定义列数
        sparseArray[0][2] = sum;                //定义非0总个数

        int num = 1;                            //记录第几个非0个数
        for (int i = 0; i < array.length;i++){
            for (int j = 0;j < array[i].length;j++){
                if (array[i][j] != 0){
                    sparseArray[num][0] = i;
                    sparseArray[num][1] = i;
                    sparseArray[num][2] = array[i][j];
                    num++;
                }
            }
        }

        //打印稀疏数组
        System.out.println("稀疏数组为：");
        for (int i = 0; i < sparseArray.length;i++){
            for (int j = 0;j < sparseArray[i].length;j++){
                System.out.print(sparseArray[i][j] + "  ");
            }
            System.out.println();
        }


        System.out.println("************************");

        /**
         * 将稀疏数组解析为原始数组
         */

        //根据稀疏数组创建原始数组大小
        int[][] arrayParse = new int[sparseArray[0][0]][sparseArray[0][1]];
        //从稀疏数组第2行开始读取原始数组中非0第位置和值，并复制给解析后第原始数组
        for (int i = 1;i < sparseArray.length;i++){
            arrayParse[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        //打印解析数组
        System.out.println("原始数组还原为：");
        for (int i = 0; i < arrayParse.length;i++){
            for (int j = 0;j < arrayParse[i].length;j++){
                System.out.print(arrayParse[i][j] + "  ");
            }
            System.out.println();
        }

    }
}
