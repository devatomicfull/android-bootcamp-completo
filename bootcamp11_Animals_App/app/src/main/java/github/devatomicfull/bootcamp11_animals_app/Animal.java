package github.devatomicfull.bootcamp11_animals_app;

public class Animal {
    private String nome;
    private int image;

    public Animal(String nome, int image) {
        this.nome = nome;
        this.image = image;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
