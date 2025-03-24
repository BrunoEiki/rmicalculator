package com.rmicalculator.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import com.rmicalculator.shared.Calculadora;
import com.rmicalculator.shared.CalculadoraImpl;

public class ServidorCalculadora {
  public static void main(String args[]) {
    try {
      // Parâmetros da linha de comando
      String ip = args[0]; // IP do servidor (ex: 192.168.1.10)
      int porta = Integer.parseInt(args[1]);
      String nomeServico = args[2]; // Nome do serviço (ex: calculadora)

      // Configura o hostname do RMI para o IP do servidor
      System.setProperty("java.rmi.server.hostname", ip);

      // Cria o Registry na porta especificada (localhost)
      LocateRegistry.createRegistry(porta);
      Registry registry = LocateRegistry.getRegistry(porta);

      // Cria o objeto remoto e gera o stub
      CalculadoraImpl calc = new CalculadoraImpl();
      Calculadora stub = (Calculadora) UnicastRemoteObject.exportObject(calc, 0);

      // Registra o stub no Registry com o nome do serviço
      registry.rebind(nomeServico, stub); // Usando rebind para evitar exceção se já existir
      System.out.println("Servidor iniciado em rmi://" + ip + ":" + porta + "/" + nomeServico);

    } catch (Exception e) {
      System.err.println("Erro no servidor: " + e.toString());
      e.printStackTrace();
    }
  }
}