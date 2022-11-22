import Head from 'next/head'
import { Container, Row, Card, Button, Image } from 'react-bootstrap'

export async function getStaticProps() {
  const res = await fetch("http://localhost:8080/movies/top250");
  const allPostsData = await res.json();
  return {
    props: {
      allPostsData
    }
  };
}

export default function Home({allPostsData}) {
  const movies = allPostsData.movies;
  return (
    <Container className="md-container">
      <Head>
        <title>ReactJS with react-bootstrap</title>
        <link rel="icon" href="/favicon-32x32.png" />
      </Head>
      <Container>
        <h1>
          IMDB Alura - 7 Days of Code
        </h1>
        <Container>
          <Row className="justify-content-md-between">
            {movies.map(({title, urlImage, rating, year}) => (
              <Card key={title} className="sml-card">
              <Card.Body>
                <Card.Title>{title}</Card.Title>
                <Card.Body>
                  <Image src={urlImage} rounded thumbnail fluid>
                  </Image> 
                </Card.Body>
                <Card.Footer>
                  Nota: {rating} - Ano: {year}
                </Card.Footer>
              </Card.Body>
            </Card>
            ))}
          </Row>
        </Container>
      </Container>

      <footer className="cntr-footer">
        <a
          href="https://vercel.com?filter=next.js&utm_source=github&utm_medium=example&utm_campaign=next-example"
          target="_blank"
          rel="noopener noreferrer"
        >
          Powered by{' '}
          <img src="/vercel.svg" alt="Vercel Logo" className="sml-logo" />
        </a>
      </footer>
    </Container>
  )
}
