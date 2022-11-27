import { Container } from 'react-bootstrap'
import MovieCardList from '../MovieCardList';
import Footer from '../Footer';
import Header from '../Header';

export default function Home({ data, page }) {
  return (
    <Container className="md-container">
      <Header />
      <MovieCardList data={data} page={page} />
      <Footer />
    </Container>
  )
}
