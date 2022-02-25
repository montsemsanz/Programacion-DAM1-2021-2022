/**
 * Demo para las clases GestorStock y Producto
 */

public class StockDemo
{
    private GestorStock gestor;

    /**
     * Crea el gestor y añade algunos productos
     */
    public StockDemo()    {
        gestor = new GestorStock();
        gestor.añadirProducto(new Producto(132, "Clock Radio"));
        gestor.añadirProducto(new Producto(37, "Mobile Phone"));
        gestor.añadirProducto(new Producto(23, "Microwave Oven"));
        gestor.añadirProducto(new Producto(23, "Microwave Oven"));
        gestor.escribirDetallesProductosV1();
        System.out.println("------------------------");
    }

    public void recibirProducto()    {
        System.out.println("Antes de recibir ....");
        gestor.escribirDetallesProductosV1();
        // Llegada de  artículos de varios productos
        gestor.recibirProducto(132, 5);
        gestor.recibirProducto(132, 15);
        gestor.recibirProducto(23, 35);
        gestor.recibirProducto(37, 6);
        System.out.println("Después de recibir ....");
        gestor.escribirDetallesProductosV1();
        System.out.println("------------------------");
    }

    /**
     * Mostrar detalles de un producto. 
     * @param id -id  del producto a buscar
     */
    public void mostrarDetalles(int id)    {
        System.out.println("Detalles del producto " + id);
        Producto producto = getProducto(id);
        if(producto != null)        {
            System.out.println(producto.toString());
        }
        System.out.println("------------------------");
    }

    /**
     * Vender un artículo de un producto
     * Mostra el estado del producto antes y después de la venta
     * @param id El id del producto vendido
     */
    public void venderProducto(int id)    {
        System.out.println("Vendiendo producto " + id);
        Producto producto = getProducto(id);        
        if(producto != null)     {
            mostrarDetalles(id);
            producto.venderUno();
            mostrarDetalles(id);
        }
        else {
            System.out.println("------------------------");            
        }
    }

    /**
     * Mostrar productos del almacén con nivel
     * de stock por debajo de cantidad
     */
    public void menorQue(int cantidad)   {
        System.out.println("Productos con stock menor a " + cantidad);
        gestor.escribirMenorQue(cantidad);
        System.out.println("------------------------");
    }

    /**
     * Obtener el producto de id dado desde el gestor.
     *
     * @param id El ID del producto
     * @return El producto o null si no se encuentra
     */
    public Producto getProducto(int id)   {
        Producto producto = gestor.localizarProducto(id);       
        return producto;
    }

    /**
     * @return El gestor de stock
     */
    public GestorStock getGestor()   {
        return gestor;
    }

    public static void main(String[] args) {
        StockDemo demo = new StockDemo();

        demo.recibirProducto();

        demo.mostrarDetalles(23);

        demo.venderProducto(23);

        demo.menorQue(10);

        int id = 132;
        Producto producto = demo.getProducto(id);
        if(producto == null) {
            System.out.println("Producto con ID: " + id +
                " no se reconoce.");
        }
        else {
            System.out.println(producto);
        }
        id = 130;
        producto = demo.getProducto(id);
        if(producto == null) {
            System.out.println("Producto con ID: " + id +
                " no se reconoce.");
        }
        else {
            System.out.println(producto);
        }
    }

}
