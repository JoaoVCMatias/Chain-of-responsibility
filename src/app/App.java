/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import java.awt.BorderLayout;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author joaov
 */
public class App {
    private static ClassServidor servidor;
    private static Random rn;
    private static int codGerado;
    private static Scanner teclado = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    private static void acessarConteudos(String nome, String senha, String cod){
        Middleware middlewareConteudos; 
        while(true){
            System.out.println("Qual conteudo voce deseja acessar?(Digite s para sair)");
            String conteudo = teclado.next();
            if(!conteudo.equals("s")){
                middlewareConteudos = new CourseExistsMiddleware(conteudo,servidor);
                middlewareConteudos.linkWith(new CourseMiddleware(servidor, conteudo));
                servidor.setMiddleware(middlewareConteudos);
                servidor.checkCursos(nome, senha, cod);
            }else{
                break;
            }
            
        }
    }
    private static void acessarServidor(String nome, String senha, String cod){
        Middleware middleware = new UserExistsMiddleware(servidor);
        middleware.linkWith(new ValidatorMiddleware(Integer.toString(codGerado)));
        servidor.setMiddleware(middleware);
        if(servidor.logIn(nome, senha, cod)){
            acessarConteudos(nome, senha, cod);
        }
        
    }
    private static void Servidor(){
        servidor = new ClassServidor();
    }
    public static void main(String[] args) {
        // TODO code application logic here
        
        Servidor();
        rn = new Random();
        //servidor.getUsuarios();
        while(true){
            System.out.println("Digite seu nome: ");
            String nome = teclado.next();
            System.out.println("Digite sua senha: ");
            String senha = teclado.next();
            codGerado = rn.nextInt(1000)+100;
            System.out.println("Digite o código que aparece na tela: " + codGerado);
            String cod = teclado.next();
            acessarServidor(nome,senha,cod);
            System.out.println("Deseja sair?(s/n)");
            if(teclado.next().equals("s")){
                break;
            }
            
        }
    }
    
}
