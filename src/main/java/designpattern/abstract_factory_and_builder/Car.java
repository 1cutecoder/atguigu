package designpattern.abstract_factory_and_builder;

/**
 * @author zcl
 * @date 2021/12/10 10:12
 */
public class Car {
    private BodyWork bodyWork;
    private Wheel wheel;
    private Engine engine;
    private Windows windows;

    public Car(Builder builder) {
        this.bodyWork = builder.bodyWork;
        this.wheel = builder.wheel;
        this.engine = builder.engine;
        this.windows = builder.windows;
    }

    public BodyWork getBodyWork() {
        return bodyWork;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public Engine getEngine() {
        return engine;
    }

    public Windows getWindows() {
        return windows;
    }

    public static final class Builder {
        private BodyWork bodyWork;
        private Wheel wheel;
        private Engine engine;
        private Windows windows;

        public Builder bodyWork(BodyWork bodyWork) {
            this.bodyWork = bodyWork;
            return this;
        }

        public Builder wheel(Wheel wheel) {
            this.wheel = wheel;
            return this;

        }

        public Builder engine(Engine engine) {
            this.engine = engine;
            return this;
        }

        public Builder windows(Windows windows) {
            this.windows = windows;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Car{");
        sb.append("bodyWork=").append(bodyWork);
        sb.append(", wheel=").append(wheel);
        sb.append(", engine=").append(engine);
        sb.append(", windows=").append(windows);
        sb.append('}');
        return sb.toString();
    }
}
