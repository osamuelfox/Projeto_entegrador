package com.samuel_fox.calendar.controller;

import com.samuel_fox.calendar.model.Evento;

import java.util.ArrayList;
import java.util.List;

public class EventoDAO {

    private final static List<Evento> eventos = new ArrayList<>();

    public List<Evento> todos() {return  new ArrayList<>(eventos);}

    public void salva(Evento evento){eventos.add(evento);}
}
