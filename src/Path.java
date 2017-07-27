import java.util.ArrayList;

public class Path
{
    private int[] iPhath;
    private int[] jPath;

    public int[] getiPhath() {
        return iPhath;
    }

    public void setiPhath(int[] iPhath) {
        this.iPhath = iPhath;
    }

    public int[] getjPath() {
        return jPath;
    }

    public void setjPath(int[] jPath) {
        this.jPath = jPath;
    }

    public Path(int[] iPhath, int[] jPath) {

        this.iPhath = iPhath;
        this.jPath = jPath;
    }
}
