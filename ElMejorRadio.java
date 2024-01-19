/*
Universidad del Valle de Guatemala
Eliazar Canastuj
carnet: 23384
*/


interface ElMejorRadio {
    void encender();
    void apagar();
    void setVolume(int volumen);
    void cambiarBanda(String banda);
    void subirEmisora();
    void bajarEmisora();
    void guardarEmisora(int boton);
    void seleccionarEmisora(int boton);
    String getEncendido();
    int getVolumen();

}