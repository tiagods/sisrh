package com.plkrhone.sisrh.model;

import java.io.Serializable;

import java.util.*;

import javax.persistence.*;

@Entity
public class Anuncio implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="criado_em")
    private Calendar criadoEm;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="criado_por_id")
    private Usuario criadoPor;
    private String nome;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="cliente_id")
    private Cliente cliente;
    private String responsavel;
    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private AnuncioStatus anuncioStatus;
    @Enumerated(EnumType.STRING)
    private Cronograma cronograma;
    @Temporal(TemporalType.DATE)
    @Column(name="data_abertura")
    private Calendar dataAbertura;
    @Temporal(TemporalType.DATE)
    @Column(name="data_encerramento")
    private Calendar dataEncerramento;
    @Temporal(TemporalType.DATE)
    @Column(name="data_admissao")
    private Calendar dataAdmissao;
    //area do formulario
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name="formulario_requisicao")
//    private FormularioRequisicao formularioRequisicao;
    //area do contrato
    @Temporal(TemporalType.DATE)
    @Column(name="data_envio_contrato")
    private Calendar dataEnvioContrato;
    @Temporal(TemporalType.DATE)
    @Column(name="data_retorno_contrato")
    private Calendar dataRetornoContrato;
    @Column(name="status_contrato")
    private String statusContrato;
    //area de curriculos
    @ManyToMany
    @JoinTable(name="anuncio_curriculo", joinColumns=
		{@JoinColumn(name="anuncio_id")}, inverseJoinColumns=
			{@JoinColumn(name="candidato_id")})
    private Set<Candidato> curriculoSet = new HashSet<>();
    //entrevistas
    @OneToMany(fetch= FetchType.LAZY,cascade= CascadeType.ALL)
    @JoinColumn(name="anuncio_id")
    private Set<AnuncioEntrevista> entrevistaSet = new HashSet<>();
    //pre selecao
    @ManyToMany
    @JoinTable(name="anuncio_pre_selecao", joinColumns=
		{@JoinColumn(name="anuncio_id")}, inverseJoinColumns=
			{@JoinColumn(name="candidato_id")})
    private Set<Candidato> preSelecaoSet = new HashSet<>();
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="candidato_aprovado_id")
    private Candidato candidatoAprovado;
    @Column(name="havera_treinamento")
    private int haveraTreinamento = 0;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="treinamento_id")
    private Treinamento treinamento;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="data_inicio_treinamento")
    private Calendar dataInicioTreinamento;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="data_fim_treinamento")
    private Calendar dataFimTreinamento;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(Calendar criadoEm) {
        this.criadoEm = criadoEm;
    }

    public Usuario getCriadoPor() {
        return criadoPor;
    }

    public void setCriadoPor(Usuario criadoPor) {
        this.criadoPor = criadoPor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public AnuncioStatus getAnuncioStatus() {
        return anuncioStatus;
    }

    public void setAnuncioStatus(AnuncioStatus anuncioStatus) {
        this.anuncioStatus = anuncioStatus;
    }

    public Cronograma getCronograma() {
        return cronograma;
    }

    public void setCronograma(Cronograma cronograma) {
        this.cronograma = cronograma;
    }

    public Calendar getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Calendar dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Calendar getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(Calendar dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public Calendar getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Calendar dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Calendar getDataEnvioContrato() {
        return dataEnvioContrato;
    }

    public void setDataEnvioContrato(Calendar dataEnvioContrato) {
        this.dataEnvioContrato = dataEnvioContrato;
    }

    public Calendar getDataRetornoContrato() {
        return dataRetornoContrato;
    }

    public void setDataRetornoContrato(Calendar dataRetornoContrato) {
        this.dataRetornoContrato = dataRetornoContrato;
    }

    public String getStatusContrato() {
        return statusContrato;
    }

    public void setStatusContrato(String statusContrato) {
        this.statusContrato = statusContrato;
    }

    public Set<Candidato> getCurriculoSet() {
        return curriculoSet;
    }

    public void setCurriculoSet(Set<Candidato> curriculoSet) {
        this.curriculoSet = curriculoSet;
    }

    public Set<AnuncioEntrevista> getEntrevistaSet() {
        return entrevistaSet;
    }

    public void setEntrevistaSet(Set<AnuncioEntrevista> entrevistaSet) {
        this.entrevistaSet = entrevistaSet;
    }

    public Set<Candidato> getPreSelecaoSet() {
        return preSelecaoSet;
    }

    public void setPreSelecaoSet(Set<Candidato> preSelecaoSet) {
        this.preSelecaoSet = preSelecaoSet;
    }

    public Candidato getCandidatoAprovado() {
        return candidatoAprovado;
    }

    public void setCandidatoAprovado(Candidato candidatoAprovado) {
        this.candidatoAprovado = candidatoAprovado;
    }

    public int getHaveraTreinamento() {
        return haveraTreinamento;
    }

    public void setHaveraTreinamento(int haveraTreinamento) {
        this.haveraTreinamento = haveraTreinamento;
    }

    public Treinamento getTreinamento() {
        return treinamento;
    }

    public void setTreinamento(Treinamento treinamento) {
        this.treinamento = treinamento;
    }

    public Calendar getDataInicioTreinamento() {
        return dataInicioTreinamento;
    }

    public void setDataInicioTreinamento(Calendar dataInicioTreinamento) {
        this.dataInicioTreinamento = dataInicioTreinamento;
    }

    public Calendar getDataFimTreinamento() {
        return dataFimTreinamento;
    }

    public void setDataFimTreinamento(Calendar dataFimTreinamento) {
        this.dataFimTreinamento = dataFimTreinamento;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
