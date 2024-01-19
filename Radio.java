/*
Universidad del Valle de Guatemala
Eliazar Canastuj
carnet: 23384
*/

class Radio implements ElMejorRadio {
    private boolean EncendendidoApagado;
    private String banda = "ninguna";
    private double emisora;
    private int volumen;
    private double[] botones = new double[12];;


    @Override
    public void encender(){
        this.banda = "FM";
        this.emisora = 87.5;
        this.EncendendidoApagado = true;
    }

    @Override
    public void apagar(){
        this.banda = "ninguna";
        this.emisora = 0;
        this.EncendendidoApagado = false;
    }

    @Override
    public void setVolume(int volumen){
        this.volumen += volumen;
    }

    @Override
    public void cambiarBanda(String banda){
        this.banda = banda;
    }

    @Override
    public void subirEmisora(){
        if (this.banda.equals("FM")){
            if(this.emisora <= 108){
                this.emisora += 0.2;
            }else{
                this.emisora = 87.5;
            }
        } 
        else if (this.banda.equals("AM")){
            if(this.emisora <= 1600){
                this.emisora += 10;
            }else{
                this.emisora = 540;
            }
        } 
    }

    @Override
    public void bajarEmisora(){
        if(this.banda.equals("FM")){
            if(this.emisora >= 87.5){
                this.emisora -= 0.2;
            }else{
                this.emisora = 87.5;
            }
        }
        else if (this.banda.equals("AM")){
            if(this.emisora >= 1600){
                this.emisora -= 10;
            }else{
                this.emisora = 540;
            }
        } 
    }

    @Override
    public void guardarEmisora(int boton){
        botones[boton] = this.emisora;
    }


    public void seleccionarEmisora(int boton){
        this.emisora = botones[boton];
    }


    @Override
    public String getEncendido(){
        if(EncendendidoApagado){
            return "Esta encendido";
        }else{
            return "Esta apagado";
        }
    }

    @Override
    public int getVolumen(){
        return this.volumen;
    }

    public double getEmisora(){
        return this.emisora;
    }

    public String getBanda(){
        return this.banda;
    }

    public boolean getEstado(){
        return this.EncendendidoApagado;
    }

    public void setEmisora(double emisora){
        this.emisora = emisora;
    }

}
