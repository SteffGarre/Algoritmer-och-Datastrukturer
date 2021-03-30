package Uppgift3;

//Klass är baserad på Princeton kod
public class Edge implements Comparable <Edge>{

    //V och W representerar en väg i NYC och weight representerar tid.

    private final int v;            //V = den första "vägen" i textfilsraden
    private final int w;            //W = den andra "vägen" i textfilsraden
    private final double weight;    // weight = tid att resa mellan V till W

    //constructor som ger V, W och Weight ett heltalsvärde (double för weight)
    public Edge(int v, int w, double weight) {
        if (v < 0) throw new IllegalArgumentException("vertex index must be a nonnegative integer");
        if (w < 0) throw new IllegalArgumentException("vertex index must be a nonnegative integer");
        if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NaN");
        this.v = v;
        this.w = w;
        this.weight = weight;
    }


    //Returnerar värde för weight
    public double weight() {
        return weight;
    }

    ////Returnerar värde för V
    public int either() {
        return v;
    }

    //Returnerar den "andra" vägen,
    public int other(int vertex) {
        if      (vertex == v) return w;
        else if (vertex == w) return v;
        else throw new IllegalArgumentException("Illegal endpoint");
    }

    //Jämför en edges weight med en annan weight i en annan edge.
    @Override
    public int compareTo(Edge that) {
        return Double.compare(this.weight, that.weight);
    }

    //en metod som printar ut en edge - weight castas till (int) för att slippa decimaler.
    public String toString() {
        return String.format("%d-%d %d", v, w, (int) weight);
    }

}
