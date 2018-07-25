package com.test.server.beans;

import com.test.lib.Paciente;
import com.test.services.PacienteServices;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "pacienteMB")
@ViewScoped
public class PacienteMB implements Serializable {

    private Paciente paciente = new Paciente();
    private List<Paciente> pacientes = new ArrayList<>();

    @Inject
    private PacienteServices pacienteServices;

    @PostConstruct
    public void init() {
        refreshPacientes();
    }

    public void refreshPaciente() {
        paciente = new Paciente();
    }

    public void refreshPacientes() {
        pacientes = pacienteServices.loadAllPacientes();
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public PacienteServices getPacienteServices() {
        return pacienteServices;
    }

    public void setPacienteServices(PacienteServices pacienteServices) {
        this.pacienteServices = pacienteServices;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public void redirectForCrud() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("selectedPaciente", paciente);
        FacesContext.getCurrentInstance().getExternalContext().redirect("pacienteCrud.xhtml");

    }

}
