/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author joaov
 */
public abstract class Middleware {
    private Middleware proximo;
    
    public Middleware linkWith(Middleware proximo) {
        this.proximo = proximo;
        return proximo;
    }
    public abstract boolean check(String nome, String senha, String cod);
    
    protected boolean checkNext(String nome, String senha, String cod) {
        if (proximo == null) {
            return true;
        }
        return proximo.check(nome, senha, cod);
    }
     
}
