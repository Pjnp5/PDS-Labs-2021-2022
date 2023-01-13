package lab3.ex2;

import java.util.Objects;

public class Plane {
    private int touristicRows;
    private int execRows;
    private int tsRow;                                                  // seats per row
    private int esRow;                                                  // seats per row

    // Construtores
    public Plane(int touristicRows, int tsRow) {
        this.touristicRows = touristicRows;
        this.tsRow = tsRow;
        this.execRows = 0;
        this.esRow = 0;
    }

    public Plane(int execRows,  int esRow, int touristicRows, int tsRow) {
        this.touristicRows = touristicRows;
        this.execRows = execRows;
        this.tsRow = tsRow;
        this.esRow = esRow;
    }

    // Setters e Getters

    public int getTouristicRows() {
        return touristicRows;
    }

    public int getExecRows() {
        return execRows;
    }

    public int getTsRow() {
        return tsRow;
    }

    public int getEsRow() {
        return esRow;
    }

    // Outros Métodos
    public int getTouristicSeats() {
        return this.touristicRows*this.tsRow;
    }

    public int getExecutiveSeats() {
        return this.execRows*this.esRow;
    }

    public int getTotalSeats() {
        return this.getTouristicSeats()+this.getExecutiveSeats();
    }

    public int getTotalRows() {
        return this.getExecRows()+this.getTouristicRows();
    }

    // Overrides

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return touristicRows == plane.touristicRows && execRows == plane.execRows && tsRow == plane.tsRow && esRow == plane.esRow;
    }

    @Override
    public int hashCode() {
        return Objects.hash(touristicRows, execRows, tsRow, esRow);
    }

    @Override
    public String toString() {
        return "Plane{" +
                "touristicRows=" + touristicRows +
                ", execRows=" + execRows +
                ", tsRow=" + tsRow +
                ", esRow=" + esRow +
                '}';
    }
}
