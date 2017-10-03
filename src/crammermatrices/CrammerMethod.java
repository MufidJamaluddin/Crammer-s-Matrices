/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crammermatrices;

/**
 *
 * @author mufidjamaluddin
 */
public class CrammerMethod {
    
    private CrammerMatrices objMatrices;
    
    /**
     * @param objMatrices the objMatrices to set
     */
    public void setObjMatrices(CrammerMatrices objMatrices) {
        this.objMatrices = objMatrices;
    }
    
    /**
     *
     * @return
     */
    public CrammerMatrices getObjMatrices()
    {
        return this.objMatrices;
    }
    
    /**
     *
     * @param dhasil
     */
    public void runCrammerMethod(int[] dhasil)
    {
        CrammerMatrices objSubMatriks;
        int matriks[][];
        int hasilSub[];
        int awal[][];
        hasilSub = new int[3];
        matriks = new int[3][3];
        awal = this.objMatrices.getMatrix(); 
        
        System.out.println("\n------- KOTRETAN METHOD CRAMMER -------");
        objSubMatriks = new CrammerMatrices();
        
        for(int j=0; j<3; j++)
        {
            // menyalin awal matriks
            for(int i=0; i<3; i++)
                System.arraycopy(awal[i], 0, matriks[i], 0, 3);    
            
            for(int i=0; i<3; i++)
            {
                matriks[i][j] = dhasil[i];
            }
            
            for(int i=0; i<3; i++)
            {
                for(int k=0; k<3; k++)
                    System.out.print(matriks[i][k] + " ");
                System.out.print("\n");
            }
            System.out.print("\n");
            
            objSubMatriks.setMatrix(matriks);
            hasilSub[j] = objSubMatriks.getDet(); 
            switch(j)
            {
                case 0:
                    System.out.print(" x = | A"+ (j+1) +" | : | A | = ");
                    break;
                case 1:
                    System.out.print(" y = | A"+ (j+1) +" | : | A | = ");
                    break;
                case 2:
                    System.out.print(" z = | A"+ (j+1) +" | : | A | = ");
                    break;
            }
            System.out.print(hasilSub[j]+" / "+this.objMatrices.getDetMatrix()+" = ");
            hasilSub[j] = hasilSub[j] / this.objMatrices.getDetMatrix();
            System.out.print(hasilSub[j]+"\n-------------------------------------\n");
        }
        this.objMatrices.setHasilkali(hasilSub);
    }
    
}