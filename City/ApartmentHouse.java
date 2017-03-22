package homework.City;

public class ApartmentHouse extends House{

    int flatnum;
    int[] flats;

    public ApartmentHouse(String street, int num, int floornum, int flatnum) {
        super.street = street;
        setNum(num);
        if (flatnum > 0) {
            this.flatnum = flatnum;
            flats = new int[flatnum];
        }
        else
            throw new IllegalArgumentException();
    }

    public void setInhabInFlat(int flatnum, int inhabnum) {
        if (flatnum > 0 && flatnum <= flats.length && inhabnum > 0) {
            flats[flatnum] = inhabnum;
            super.inhabnum += inhabnum;
        }
        else
            throw new IllegalArgumentException();
    }

    public int getFlatnum() {
        return flatnum;
    }
}
