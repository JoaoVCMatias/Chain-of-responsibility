/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author joaov
 */
public class UserExistsMiddleware extends Middleware{
    private ClassServidor servidor;

    public UserExistsMiddleware(ClassServidor servidor) {
        this.servidor = servidor;
    }
   
    @Override
    public boolean check(String nome, String senha, String cod) {
        if (!servidor.possuiNome(nome)) {
            System.out.println("Nome invalido!");
            return false;
        }
        if (!servidor.usuarioValido(nome, senha)) {
            System.out.println("Senha invalida!");
            return false;
        }
        return checkNext(nome, senha, cod);
    }

 
    
}
