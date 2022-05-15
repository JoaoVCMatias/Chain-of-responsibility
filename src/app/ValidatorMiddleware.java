/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author joaov
 */
public class ValidatorMiddleware extends Middleware {
    private static String codTela;
    
     public ValidatorMiddleware() {
    }
    public ValidatorMiddleware(String cTela) {
        System.out.println(cTela);
        this.codTela = cTela;
    }
    
    @Override
    public boolean check(String nome, String senha, String cod) {
        System.out.println("CodTela :" + this.codTela + "Cod digit: " + cod);
        if(this.codTela.equals(cod)){
            System.out.println("Código correto");
            return checkNext(nome, senha, cod);
        }
        System.out.println("Código errado");
        return false;
    }

    

    
}
