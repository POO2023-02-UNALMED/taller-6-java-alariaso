package vehiculos;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Vehiculo {
    private String placa;
    private int puertas;
    private int velocidadMaxima;
    private String nombre;
    private int precio;
    private int peso;
    private String traccion;
    private Fabricante fabricante;
    private static int CantidadVehiculos;
    private static Map<Pais, Integer> paisesConteo = new HashMap<>();
    private static Map<Fabricante, Integer> fabricasConteo = new HashMap<>();

    public Vehiculo(String placa, int puertas, int velocidadMaxima, String nombre, int precio, int peso, String traccion, Fabricante fabricante) {
        this.placa = placa;
        this.puertas = puertas;
        this.velocidadMaxima = velocidadMaxima;
        this.nombre = nombre;
        this.precio = precio;
        this.peso = peso;
        this.traccion = traccion;
        this.fabricante = fabricante;
        CantidadVehiculos++;

        Pais pais = fabricante.getPais();
        paisesConteo.put(pais, paisesConteo.getOrDefault(pais, 0) + 1);
        fabricasConteo.put(fabricante, fabricasConteo.getOrDefault(fabricante, 0) + 1);
    }

    public static int getCantidadVehiculos() {
        return CantidadVehiculos;
    }

    public static void setCantidadVehiculos(int cantidadVehiculos) {
        CantidadVehiculos = cantidadVehiculos;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public String vehiculosPorTipo() {
        int automoviles = Automovil.getCantidad();
        int camionetas = Camioneta.getCantidad();
        int camiones = Camion.getCantidad();
        return String.format("Automoviles: %s\n" +
                "Camionetas: %s\n" +
                "Camiones: %s", automoviles, camionetas, camiones);
    }

    static Pais getPaisMasVendedor() {
        return Collections.max(paisesConteo.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    static Fabricante getFabricaMayorVentas() {
        return Collections.max(fabricasConteo.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
