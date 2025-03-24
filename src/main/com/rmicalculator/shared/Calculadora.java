package com.rmicalculator.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculadora extends Remote {
    public Numero soma (Numero a, Numero b)
        throws RemoteException;

    public Numero subtrai (Numero a, Numero b)
        throws RemoteException;

    public Numero multiplica (Numero a, Numero b)
        throws RemoteException;

    public Numero divide (Numero a, Numero b)
            throws RemoteException, DivisaoPorZeroException;
        
    public Numero divideInteiro (Numero a, Numero b)
            throws RemoteException, DivisaoPorZeroException;
        
    public Numero restoDivisao (Numero a, Numero b)
            throws RemoteException, DivisaoPorZeroException;
        
    public Numero exponencia (Numero a, Numero b)
            throws RemoteException, DivisaoPorZeroException;

    public Numero raizQuadrada(Numero a) throws RemoteException, NumeroNegativoException;
    public Numero logaritmoNatural(Numero a) throws RemoteException, NumeroInvalidoException;
    public Numero numeroAleatorio(Numero min, Numero max) throws RemoteException;
    public Numero valorAbsoluto(Numero a) throws RemoteException;
    public Numero arredondar(Numero a) throws RemoteException;
    public Numero maximo(Numero a, Numero b) throws RemoteException;
    public Numero grausParaRadianos(Numero graus) throws RemoteException;
    public Numero seno(Numero graus) throws RemoteException;

    public Numero media(Numero[] numeros) throws RemoteException;
    
    }
