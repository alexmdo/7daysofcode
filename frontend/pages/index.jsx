import axios from 'axios';
import Index from '../src/components/Index'

export async function getServerSideProps({ query: { page = 0 } }) {
  const res = await axios.get(`http://localhost:8080/movies/top250?page=${page}`);
  const data = res.data;
  return {
    props: {
      data,
      page: parseInt(page, 10)
    }
  };
}

export default function IndexPage({ data, page }) {
  return (
    <Index data={data} page={page} />
  )
}