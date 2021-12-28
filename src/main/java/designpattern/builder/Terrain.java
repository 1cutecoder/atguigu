package designpattern.builder;

/**
 * @author zcl
 * @date 2021/12/9 9:48
 */
public class Terrain {
    Wall w;
    Fort f;
    Mine m;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Terrain{");
        sb.append("w=").append(w);
        sb.append(", f=").append(f);
        sb.append(", m=").append(m);
        sb.append('}');
        return sb.toString();
    }
}

class Wall {
    int x, y, w, h;

    public Wall(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Wall{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", w=").append(w);
        sb.append(", h=").append(h);
        sb.append('}');
        return sb.toString();
    }
}

class Fort {
    int x, y, w, h;

    public Fort(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Fort{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", w=").append(w);
        sb.append(", h=").append(h);
        sb.append('}');
        return sb.toString();
    }
}

class Mine {
    int x, y, w, h;

    public Mine(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Mine{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", w=").append(w);
        sb.append(", h=").append(h);
        sb.append('}');
        return sb.toString();
    }
}
