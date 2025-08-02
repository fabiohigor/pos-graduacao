import Link from "next/link";

const Page = () => (
    <div>
      <Link className="underline" href="/nivel-0/joao">Ir para a página do João</Link><br />
      <Link className="underline" href="/nivel-0/maria">Ir para a página da Maria</Link><br />
      <Link className="underline" href="/nivel-0/fulano">Ir para a página do Fulano</Link><br />
      <Link className="underline" href="/nivel-0/ciclano">Ir para a página do Ciclano</Link><br />
      <Link className="underline" href="/nivel-0/abel">Ir para a página do Abel</Link><br />
      
    </div>
);

export default Page;