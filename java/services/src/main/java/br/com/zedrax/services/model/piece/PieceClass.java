package br.com.zedrax.services.model.piece;

//OK
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Length;

/**
 * The persistent class for the "piece-class" database table.
 * 
 */
@Entity
@Table(name = "piece-class", uniqueConstraints = @UniqueConstraint(name = "uk_piece-class__class", columnNames = "class"))
public class PieceClass implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_piece-class", nullable = false, insertable = false, updatable = false)
    private Long idPieceClass;

    @Column(name = "class", nullable = false)
    @Length(max = 10)
    private String clazz;

    @OneToMany(mappedBy = "pieceClass", targetEntity = PieceType.class)
    private List<PieceType> pieceTypes;

    public PieceClass() {
    }

    public PieceClass(String clazz) {
        
        setClazz(clazz);
    }

    public Long getIdPieceClass() {
        return idPieceClass;
    }

    public void setIdPieceClass(Long idPieceClass) {
        this.idPieceClass = idPieceClass;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public List<PieceType> getPieceTypes() {
        return pieceTypes;
    }

    public void setPieceTypes(List<PieceType> pieceTypes) {
        this.pieceTypes = pieceTypes;
    }

    @Override
    public boolean equals(Object obj) {
        
        boolean equals = false;

        if (obj != this) {
            
            if (obj instanceof PieceClass) {
                
                PieceClass pieceType = (PieceClass) obj;

                if (Objects.equals(clazz, pieceType.getClazz())) {
                    equals = true;
                }
            }
        }

        return equals;
    }
}