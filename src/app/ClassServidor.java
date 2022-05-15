/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author joaov
 */
public class ClassServidor {
    private Map<String, String> usuarios = new HashMap<>(); //Nome e senha(para a validação do usuario)
    private Map<String, String> usuariosPagantes = new HashMap<>(); //Nome e valor pago dos usuarios pagantes
    private Middleware middleware;
    
    public void setMiddleware(Middleware middleware) {
        this.middleware = middleware;
    }
    
    public boolean logIn(String nome, String senha) {
        if (middleware.check(nome, senha)) {
            System.out.println("Usuario valido");
            return true;
        }
        return false;
    }
    
    public ClassServidor() {
        usuarios.put("Joao", "123");
        usuarios.put("Maria", "456");
        usuarios.put("Pedro", "789");
        inserirPlanoPrata("Maria");
        inserirPlanoOuro("Pedro");
    }
    
    public void inserirPlanoPrata(String nome){
        usuariosPagantes.put(nome, "Prata");
    }
    
    public void inserirPlanoOuro(String nome){
        usuariosPagantes.put(nome, "Ouro");
    }
    
    public void novoUsuario(String nome, String senha, String plano){
        usuarios.put(nome, senha);
        if(plano.equals("Prata")){
            inserirPlanoPrata(nome);
        }
        if(plano.equals("Ouro")){
            inserirPlanoOuro("nome");
        }
    }
    
    public Boolean possuiNome(String nome){
        return usuarios.containsKey(nome);
    }
    public Boolean usuarioValido(String nome, String senha){
        return usuarios.get(nome).equals(senha);
    }
    public void getUsuarios(){
        System.out.println(usuarios);
                
    }
    
    
    
    
    
}
