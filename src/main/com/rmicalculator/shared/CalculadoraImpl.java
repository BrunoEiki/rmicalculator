package com.rmicalculator.shared;

public class CalculadoraImpl implements Calculadora {

    public Numero soma (Numero a, Numero b) {
        return new NumeroImpl (a.getValor() + b.getValor());
    }

    public Numero subtrai (Numero a, Numero b) {
        return new NumeroImpl (a.getValor() - b.getValor());
    }

    public Numero multiplica (Numero a, Numero b)  {
        return new NumeroImpl (a.getValor() * b.getValor());
    }

    public Numero divide (Numero a, Numero b)
            throws DivisaoPorZeroException {
        if (b.getValor() == 0)
            throw new DivisaoPorZeroException();
        return new NumeroImpl(a.getValor() / b.getValor());
    }
    
    public Numero divideInteiro (Numero a, Numero b)
            throws DivisaoPorZeroException {
        if (b.getValor() == 0)
            throw new DivisaoPorZeroException();
        return new NumeroImpl(Math.floor(a.getValor() / b.getValor()));
    }
    
    public Numero restoDivisao (Numero a, Numero b)
            throws DivisaoPorZeroException {
        if (b.getValor() == 0)
            throw new DivisaoPorZeroException();
        return new NumeroImpl(a.getValor() % b.getValor());
    }
    
    public Numero exponencia (Numero a, Numero b)  {
        return new NumeroImpl ( Math.pow(a.getValor(), b.getValor()) );
    }

    public Numero raizQuadrada(Numero a) throws NumeroNegativoException {
        if (a.getValor() < 0)
            throw new NumeroNegativoException();
        return new NumeroImpl(Math.sqrt(a.getValor()));
    }

    public Numero logaritmoNatural(Numero a) throws NumeroInvalidoException {
        if (a.getValor() <= 0)
            throw new NumeroInvalidoException();
        return new NumeroImpl(Math.log(a.getValor()));
    }

    public Numero numeroAleatorio(Numero min, Numero max) {
        double randomValue = min.getValor() + (Math.random() * (max.getValor() - min.getValor()));
        return new NumeroImpl(randomValue);
    }

    public Numero valorAbsoluto(Numero a) {
        return new NumeroImpl(Math.abs(a.getValor()));
    }

    public Numero arredondar(Numero a) {
        return new NumeroImpl(Math.round(a.getValor()));
    }

    public Numero maximo(Numero a, Numero b) {
        return new NumeroImpl(Math.max(a.getValor(), b.getValor()));
    }

    public Numero grausParaRadianos(Numero graus) {
        return new NumeroImpl(Math.toRadians(graus.getValor()));
    }

    public Numero seno(Numero graus) {
        return new NumeroImpl(Math.sin(Math.toRadians(graus.getValor())));
    }

    public Numero media(Numero[] numeros) {
    double soma = 0;
    for (Numero num : numeros) {
        soma += num.getValor();
    }
    return new NumeroImpl(soma / numeros.length);
}

    
}
