/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crammermatrices;

import java.util.Scanner;

/**
 *
 * @author mufidjamaluddin
 */
public class CrammerMatrices {
    
    private int matrix[][];
    private int hasilkali[];
    private int detMatrix;
    
    /**
     * @param matrix the matrix to set
     */
    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
    
    /**
     * @return the matrix
     */
    public int[][] getMatrix() {
        return matrix;
    }
    
    /**
     *
     * @param i
     * @param j
     * @return
     */
    public int getSpesMatrix(int i, int j)
    {
        return matrix[i][j];
    }
    
    public int getDet()
    {
        
        int sumDet;
        int[] detM = new int[3];
        
        System.out.println(this.getSpesMatrix(1,1) + " " + this.getSpesMatrix(1,2) + "\n" + this.getSpesMatrix(2,1) + " " + this.getSpesMatrix(2,2));
        detM[0] = (this.getSpesMatrix(1,1) * this.getSpesMatrix(2,2)) - (this.getSpesMatrix(1,2) * this.getSpesMatrix(2,1))  ;
        System.out.println("Det : " + detM[0] + "\n");
        
        System.out.println(this.getSpesMatrix(1,0) + " " + this.getSpesMatrix(1,2) + "\n" + this.getSpesMatrix(2,0) + " " + this.getSpesMatrix(2,2));
        detM[1] =  (this.getSpesMatrix(1,2) * this.getSpesMatrix(2,0)) - (this.getSpesMatrix(1,0) * this.getSpesMatrix(2,2));
        System.out.println("Det : " + detM[1] + "\n");
        
        System.out.println(this.getSpesMatrix(1,0) + " " + this.getSpesMatrix(1,1) + "\n" + this.getSpesMatrix(2,0) + " " + this.getSpesMatrix(2,1));
        detM[2] =  (this.getSpesMatrix(1,0) * this.getSpesMatrix(2,1)) - (this.getSpesMatrix(1,1) * this.getSpesMatrix(2,0));
        
        System.out.println("Det : " + detM[2] + "\n");
        
        sumDet = ( detM[0] * this.getSpesMatrix(0,0) ) + ( detM[1] * this.getSpesMatrix(0,1) ) + ( detM[2] * this.getSpesMatrix(0,2) );
        this.detMatrix = sumDet;
        System.out.println("Det Matriks = ( "+detM[0]+" x "+this.getSpesMatrix(0,0)+" ) + ( "+detM[1]+" x "+this.getSpesMatrix(0,1)+" ) + ( "+detM[2]+" x "+this.getSpesMatrix(0,2)+" ) = " + sumDet +"\n");
        
        return sumDet;
    }
    
    public boolean isHaveSolution()
    {
        System.out.println("\n----------- KOTRETAN DETERMINAN ----------\n");
        this.detMatrix = this.getDet();      
        return this.detMatrix != 0; 
    }
    
    public int getDetMatrix()
    {
        return this.detMatrix;
    }
    
    /**
     * @return the hasilkali
     */
    protected int[] getHasilkali() {
        return hasilkali;
    }
    
    /**
     * @param hasilkali the hasilkali to set
     */
    protected void setHasilkali(int[] hasilkali) {
        this.hasilkali = hasilkali;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        CrammerMatrices objMatriks;
        CrammerMethod objCrammerMethod;
        Scanner input;
        
        int a[][] = new int[3][3];
        double b[][] = new double[3][3];
        int kiri[] = new int[3];
        int hasil[];
        input = new Scanner(System.in);   
        
        System.out.println("Masukkan Matriks : ");
        
        a[0][0] = input.nextInt();
        a[0][1] = input.nextInt();
        a[0][2] = input.nextInt();

        a[1][0] = input.nextInt();
        a[1][1] = input.nextInt();
        a[1][2] = input.nextInt();

        a[2][0] = input.nextInt();
        a[2][1] = input.nextInt();
        a[2][2] = input.nextInt();
        
        System.out.println("Dikali\n| x |\n| y |\n| z |\n = ");
        
        kiri[0] = input.nextInt();
        kiri[1] = input.nextInt();
        kiri[2] = input.nextInt();
        
        objMatriks = new CrammerMatrices();
        objMatriks.setMatrix(a);
        
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                b[i][j] = (double) a[i][j];
        
        if(objMatriks.isHaveSolution())
        {
            System.out.println("CARI NILAI x, y DAN z");
            objCrammerMethod = new CrammerMethod();
            objCrammerMethod.setObjMatrices(objMatriks);
            objCrammerMethod.runCrammerMethod(kiri);
            
            hasil = objMatriks.getHasilkali();
            System.out.println("\n-------------------------\n Determinan Matriks : " + objMatriks.getDetMatrix() + "\nNilai : \n x = " + hasil[0] + "\n y = " + hasil[1] + "\n z = " + hasil[2]);
            
            b = Inverse.invert(b);
            
            System.out.println("\n--------------------------\n Invers Nya Adalah (dg Gauss Method )");

            for (int i=0; i<3; ++i) 
            {
                for (int j=0; j<3; ++j)
                {
                    System.out.print(String.format(" %2.2f ",b[i][j]));
                }
                System.out.print("\n");
            }
            
        }
        else
        {
            System.out.println("Determinan Matriks Anda Nol\n\nJadi, Matriks yang Anda Inputkan : \n1. Solusi Banyak atau Tidak Ada Solusi.\n2. Tidak Memiliki Invers");
        }
        
        input.close();
    }
   
}