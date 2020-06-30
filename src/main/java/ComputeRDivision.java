
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.*;

public class ComputeRDivision {
    /*
     * trivially computes an r-Division of a graph
     * in O(|V| log |V|) time
     */

    // g: the graph
    private Graph g;
    // r: number of divisions.
    private int r;

    protected static int rOpt(int n) {
        // take r to be (log2(n) / log2(log2(n)))^2
        // use fast base2 integer log.
        int l = FastMath.fastI32Log2(n);
        int d = (int) ((float)(l) / (float)FastMath.fastI32Log2(l));
        return d*d;
    }

    public ComputeRDivision(Graph g, int r) {
        this.g = g;
    }

    // computes an r-division using the trivial algorithm.
    private void computeDivision() {

    }
}
