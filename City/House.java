package homework.City;

public class House implements Building{

    String street;
    int num;
    int floornum;
    int inhabnum;

    @Override
    public void build() {
        House(street, num, floornum, inhabnum);
    }
    @Override
    public void destroy() {
        this.street = null;
        this.floornum = 0;
        this.inhabnum = 0;
        this.num = 0;
    }

    public void House(String street, int num, int floornum, int inhabnum) {
        this.street = street;
        if (num > 0)
            this.num = num;
        else
            throw new IllegalArgumentException();
        if (floornum > 0)
            this.floornum = floornum;
        else
            throw new IllegalArgumentException();
        if (inhabnum > 0)
            this.inhabnum = inhabnum;
        else
            throw new IllegalArgumentException();
    }

    public void House(String street, int num) {
        this.street = street;
        if (num > 0)
            this.num = num;
        else
            throw new IllegalArgumentException();
        this.inhabnum = 0;
        this.floornum = 1;
    }

    public String getStreet() {
        return street;
    }

    public int getNum() {
        return num;
    }

    public int getFloornum() {
        return floornum;
    }

    public int getInhabnum() {
        return inhabnum;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNum(int num) {
        if (num > 0)
            this.num = num;
        else
            throw new IllegalArgumentException();
    }

    public void setFloornum(int floornum) {
        if (floornum > 0)
            this.floornum = floornum;
        else
            throw new IllegalArgumentException();
    }

    public void setInhabnum(int inhabnum) {
        if (inhabnum > 0)
            this.inhabnum = inhabnum;
        else
            throw new IllegalArgumentException();
    }
}
