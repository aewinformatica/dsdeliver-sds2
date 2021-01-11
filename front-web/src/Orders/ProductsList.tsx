import ProductCard from "./ProductCard";
import { Product } from "./Types";

type Props = {
  products: Product[];
}
function ProductsList({products}: Props) {
  return (
    <header className="orders-list-container">
      <div className="orders-list-items">
           {products.map(product => (
             <ProductCard key={product.id} product={product}/>
           ))}
      </div>
    </header>
  )
}

export default ProductsList;