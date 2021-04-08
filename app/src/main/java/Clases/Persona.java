package Clases;

public class Persona {
    private String Nombre;
    private String Apellido;
    private int Edad;
    private String Email;
    private String Cargo;
    private int Salario;

    public Persona(){

    }

    public Persona(String nombre, String apellido, int edad, String email, String cargo, int salario){

        setNombre(nombre);
        setApellido(apellido);
        setEdad(edad);
        setEmail(email);
        setCargo(cargo);
        setSalario(salario);

    }


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String cargo) {
        Cargo = cargo;
    }

    public int getSalario() {
        return Salario;
    }

    public void setSalario(int salario) {
        Salario = salario;
    }
}
