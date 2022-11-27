import Head from 'next/head'
import Link from 'next/link'
import Router from 'next/router';
import { Container, Row, Card, Button, Image } from 'react-bootstrap'

export async function getServerSideProps({ query: { page = 0 } }) {
  const res = await fetch(`http://localhost:8080/movies/top250?page=${page}`);
  const data = await res.json();
  return {
    props: {
      data,
      page: parseInt(page, 10)
    }
  };
}

export default function Home({ data, page }) {
  const movies = data.content;
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
            {movies.map(({ title, urlImage, rating, year }) => (
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
          <Row className='justify-content-md-center'>
            <Button
              onClick={() => Router.push(`/?page=${page - 1}`)}
              disabled={page <= 0}>
              Anterior
            </Button>
            <p>&nbsp;&nbsp;</p>
            <Button onClick={() => Router.push(`/?page=${page + 1}`)}>
              Proximo
            </Button>
            <p>&nbsp;&nbsp;</p>
            <Link href="/?page=0">
              {` <<`}
            </Link>
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
