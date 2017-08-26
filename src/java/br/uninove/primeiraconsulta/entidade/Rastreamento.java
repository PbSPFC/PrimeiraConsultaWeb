/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.entidade;

/**
 *
 * @author PB
 */
public class Rastreamento {

    private String nivel;
    private String rastreamento;
    private String titulo;
    private String texto;

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getRastreamento() {
        return rastreamento;
    }

    public void setRastreamento(String rastreamento) {
        this.rastreamento = rastreamento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}

