package elements.tp1;

/**
 * Created by Ryad on 19/10/2018.
 */
public class Item {
    private long gain;
    private long poid;
    private boolean pri;

    public Item(long poid,long gain)
    {
        setPoid(poid);
        setgain(gain);
    }

    public void setPoid(long poid) {
        this.poid = poid;
    }
    public void setgain(long gain) {
        this.gain = gain;
    }
    public long getPoid() {
        return poid;
    }
    public long getGain() {
        return gain;
    }

}
