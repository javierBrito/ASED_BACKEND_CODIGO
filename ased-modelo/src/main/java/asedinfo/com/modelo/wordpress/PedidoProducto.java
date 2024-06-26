package asedinfo.com.modelo.wordpress;
// default package

// Generated Oct 29, 2013 4:10:51 PM by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Persona generated by hbm2java
 */
@Entity
@Table(name = "wp_wc_order_product_lookup")
public class PedidoProducto implements java.io.Serializable {
	private static final long serialVersionUID = -8622196233866959952L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_item_id", unique = true, nullable = false, precision = 10, scale = 0)
	private Long orderItemId;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	private Pedido pedido;
	@Transient
	private Long orderId;	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private ProductoWP productoWP;
	@Transient
	private Long productId;	
	@Transient
	private String postExcerpt;
	@Transient
	private String postTitle;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private ClienteWP clienteWP;
	@Transient
	private Long customerId;
	/*
	@OneToOne
	@JoinColumn(name = "customer_id")
	private ClienteWP clienteWP;
	*/
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "es-EC", timezone = "America/Lima")
	@Column(name = "date_created", length = 23)
	private Date dateCreated;
	
	public PedidoProducto() {
	}

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Long getOrderId() {
		if (this.pedido != null) {
			orderId = this.pedido.getOrderId();
		}
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public ProductoWP getProductoWP() {
		return productoWP;
	}

	public void setProductoWP(ProductoWP productoWP) {
		this.productoWP = productoWP;
	}

	public Long getProductId() {
		if (this.productoWP != null) {
			productId = this.productoWP.getId();
		}
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public ClienteWP getClienteWP() {
		return clienteWP;
	}

	public void setClienteWP(ClienteWP clienteWP) {
		this.clienteWP = clienteWP;
	}

	public Long getCustomerId() {
		if (this.clienteWP != null) {
			customerId = this.clienteWP.getCustomerId();
		}
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getPostExcerpt() {
		if (this.productoWP != null) {
			postExcerpt = this.productoWP.getPostExcerpt();
		}
		return postExcerpt;
	}

	public void setPostExcerpt(String postExcerpt) {
		this.postExcerpt = postExcerpt;
	}

	public String getPostTitle() {
		if (this.productoWP != null) {
			postTitle = this.productoWP.getPostTitle();
		}
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
}
