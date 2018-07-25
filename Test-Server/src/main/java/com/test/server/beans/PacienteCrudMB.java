package com.test.server.beans;

import com.test.lib.Paciente;
import com.test.services.PacienteServices;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "pacienteCrudMB")
@ViewScoped
public class PacienteCrudMB implements Serializable {

    private Paciente paciente;

    @Inject
    private PacienteServices pacienteServices;

    @PostConstruct
    public void init() {
        paciente = (Paciente) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("selectedPaciente");
        if (Objects.isNull(paciente)) {
            paciente = new Paciente();
        }
    }

    public void save() throws IOException {
        pacienteServices.save(paciente);
        redirectForPacientes();
    }

    public void update() throws IOException {
        pacienteServices.update(paciente);
        redirectForPacientes();
    }

    public void delete() throws IOException {
        pacienteServices.delete(paciente.getId());
        redirectForPacientes();
    }

    public void refreshPaciente() {
        paciente = new Paciente();
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

    public void redirectForPacientes() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("pacientes.xhtml");
    }

}
