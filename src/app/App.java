/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import java.awt.BorderLayout;
import java.util.Scanner;

/**
 *
 * @author joaov
 */
public class App {
    private static ClassServidor servidor;
    /**
     * @param args the command line arguments
     */
    private static void acessarServidor(String nome, String senha){
        Middleware middleware = new UserExistsMiddleware(servidor);
        servidor.setMiddleware(middleware);
        if(servidor.logIn(nome, senha)){
            System.out.println("Qual conteudo voce deseja acessar?");
        }
        
    }
    private static void Servidor(){
        servidor = new ClassServidor();
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        Servidor();
        //servidor.getUsuarios();
        while(true){
            System.out.println("Digite seu nome: ");
            String nome = teclado.next();
            System.out.println("Digite sua senha: ");
            String senha = teclado.next();
            acessarServidor(nome,senha);
            System.out.println("Deseja sair?(s/n)");
            if(teclado.next().equals("s")){
                break;
            }
            
        }
    }
    
}
