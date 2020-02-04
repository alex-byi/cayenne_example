package org.apache.cayenne.example.model.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.example.model.Gallery;
import org.apache.cayenne.example.model.Painting;
import org.apache.cayenne.exp.Property;

/**
 * Class _Exhibit was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Exhibit extends BaseDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String EXHIBIT_ID_PK_COLUMN = "exhibit_id";

    public static final Property<LocalDateTime> CLOSING_DATE = Property.create("closingDate", LocalDateTime.class);
    public static final Property<LocalDateTime> OPENING_DATE = Property.create("openingDate", LocalDateTime.class);
    public static final Property<Gallery> GALLERY = Property.create("gallery", Gallery.class);
    public static final Property<List<Painting>> PAINTINGS = Property.create("paintings", List.class);

    protected LocalDateTime closingDate;
    protected LocalDateTime openingDate;

    protected Object gallery;
    protected Object paintings;

    public void setClosingDate(LocalDateTime closingDate) {
        beforePropertyWrite("closingDate", this.closingDate, closingDate);
        this.closingDate = closingDate;
    }

    public LocalDateTime getClosingDate() {
        beforePropertyRead("closingDate");
        return this.closingDate;
    }

    public void setOpeningDate(LocalDateTime openingDate) {
        beforePropertyWrite("openingDate", this.openingDate, openingDate);
        this.openingDate = openingDate;
    }

    public LocalDateTime getOpeningDate() {
        beforePropertyRead("openingDate");
        return this.openingDate;
    }

    public void setGallery(Gallery gallery) {
        setToOneTarget("gallery", gallery, true);
    }

    public Gallery getGallery() {
        return (Gallery)readProperty("gallery");
    }

    public void addToPaintings(Painting obj) {
        addToManyTarget("paintings", obj, true);
    }

    public void removeFromPaintings(Painting obj) {
        removeToManyTarget("paintings", obj, true);
    }

    @SuppressWarnings("unchecked")
    public List<Painting> getPaintings() {
        return (List<Painting>)readProperty("paintings");
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "closingDate":
                return this.closingDate;
            case "openingDate":
                return this.openingDate;
            case "gallery":
                return this.gallery;
            case "paintings":
                return this.paintings;
            default:
                return super.readPropertyDirectly(propName);
        }
    }

    @Override
    public void writePropertyDirectly(String propName, Object val) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch (propName) {
            case "closingDate":
                this.closingDate = (LocalDateTime)val;
                break;
            case "openingDate":
                this.openingDate = (LocalDateTime)val;
                break;
            case "gallery":
                this.gallery = val;
                break;
            case "paintings":
                this.paintings = val;
                break;
            default:
                super.writePropertyDirectly(propName, val);
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        writeSerialized(out);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        readSerialized(in);
    }

    @Override
    protected void writeState(ObjectOutputStream out) throws IOException {
        super.writeState(out);
        out.writeObject(this.closingDate);
        out.writeObject(this.openingDate);
        out.writeObject(this.gallery);
        out.writeObject(this.paintings);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.closingDate = (LocalDateTime)in.readObject();
        this.openingDate = (LocalDateTime)in.readObject();
        this.gallery = in.readObject();
        this.paintings = in.readObject();
    }

}
