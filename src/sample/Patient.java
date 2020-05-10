package sample;

public class Patient {
    private String firstname;
    private String name;
    private String patronymic;
    private String birthdate;
    private String insurance;
    private String fDiagnose;
    private String anamnesis;
    private String diagnostics;
    private String treatment;
    private String gender;


    public Patient(String firstname, String name, String patronymic, String birthdate, String insurance,
                   String fDiagnose, String anamnesis, String diagnostics, String treatment, String gender) {

        this.firstname = firstname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthdate = birthdate;
        this.insurance = insurance;
        this.fDiagnose = fDiagnose;
        this.anamnesis = anamnesis;
        this.diagnostics = diagnostics;
        this.treatment = treatment;
        this.gender = gender;
    }

    public Patient() {}


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getfDiagnose() {
        return fDiagnose;
    }

    public void setfDiagnose(String fDiagnose) {
        this.fDiagnose = fDiagnose;
    }

    public String getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(String anamnesis) {
        this.anamnesis = anamnesis;
    }

    public String getDiagnostics() {
        return diagnostics;
    }

    public void setDiagnostics(String diagnostics) {
        this.diagnostics = diagnostics;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}