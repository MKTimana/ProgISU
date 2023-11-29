public class Produto{
    private int id;
    private String nome;
    private int quant;
    private double preco;

    

    public Produto() {
    }
    
    public Produto(int id, String nome, int quant, double preco) {
        this.id = id;
        this.nome = nome;
        this.quant = quant;
        this.preco = preco;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getQuant() {
        return quant;
    }
    public void setQuant(int quant) {
        this.quant = quant;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    
}